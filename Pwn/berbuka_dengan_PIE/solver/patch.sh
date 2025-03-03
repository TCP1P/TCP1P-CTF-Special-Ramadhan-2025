# to patch
pwninit
# to copy the libc.so.6 from docker
sudo docker compose cp ret2win2:/lib/x86_64-linux-gnu/libc.so.6 .
# to run solver into the remote
python3 solver.py RMT localhost 19001