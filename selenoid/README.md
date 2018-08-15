## Selenoid

Folder contains files for <a href='https://aerokube.com/selenoid/latest/'>selenoid</href>

* `config` folder - here is configuration file for browsers
* `stop_env.sh` - running this file will stop all selenoid containers
* `run_selenoid.sh` - running this file will pull docker images with browsers, 
start docker containers with selenoid and selenoid ui.

After running `run_selenoid.sh` to check that all is started successfully - go to <a href='http://localhost:7777/#/'>http://localhost:7777/#/</a> and see ui of selenoid.