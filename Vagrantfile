VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

	config.vm.box = "puppetlabs/centos-6.5-32-nocm"
	config.omnibus.chef_version = :latest

	config.vm.network :forwarded_port, guest: 80, host: 20080 # http
	config.vm.network :forwarded_port, guest: 8080, host: 28080 # http

	config.vm.synced_folder "./src", "/var/www/src", :create => true, :owner => 'vagrant', :group => 'vagrant', :mount_options => ['dmode=777', 'fmode=666']

	config.vm.provision "chef_solo" do |chef|
		chef.cookbooks_path = "chef/site-cookbooks/"
		chef.run_list = %w[
			recipe[java]
		]
	end

end
