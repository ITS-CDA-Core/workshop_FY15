execute "rpm import jenkins-ci.org.key" do
	command "rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key"
	action :run
	not_if { ::File.exists?("/etc/yum.repos.d/jenkins.repo") }
end

remote_file "/etc/yum.repos.d/jenkins.repo" do
	source "http://pkg.jenkins-ci.org/redhat/jenkins.repo"
	action :create
end

package "jenkins" do
	action :install
	notifies :run, "ruby_block[edit /etc/sysconfig/jenkins]", :immediately
end

ruby_block "edit /etc/sysconfig/jenkins" do
	block do
		_file = Chef::Util::FileEdit.new("/etc/sysconfig/jenkins")
		_file.search_file_replace_line('^JENKINS_PORT', "JENKINS_PORT=\"" + node["jenkins"]["port"] + "\"\n")
		_file.search_file_replace_line('^JENKINS_AJP_PORT', "JENKINS_AJP_PORT=\"" + node["jenkins"]["ajp_port"] + "\"\n")
		_file.write_file
	end
	action :nothing
end

service "jenkins" do
	action [:enable, :start]
end

