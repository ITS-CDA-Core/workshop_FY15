#
# Cookbook Name:: node.js
# Recipe:: sample_01
#
bash "install and launch final-up" do
	code <<-EOH
		. /usr/local/nvm/nvm.sh
		nvm use v#{node.version}
		cd /var/src/
		npm install --no-bin-links
		pm2 startOrRestart ecosystem.json --watch
	EOH
end
