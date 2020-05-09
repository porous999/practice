from ssh_utils.get_ip_address import get_ip_address
from ssh_utils.is_port_open import isOpen

IP_PREFIX = "192.168.0."
PORT=8080
NETWORK_INTERFACE_NAME = "wlp6s0"

if __name__ == "__main__":

    my_ip = get_ip_address(NETWORK_INTERFACE_NAME.encode('ASCII'))
    print("My IP address is: %s " % my_ip)

    ssh_host_list = []
    for i in range(1, 254):
        host_ip = IP_PREFIX + str(i)

        if host_ip == my_ip:
            print('Skipping my machine... IP: %s' %host_ip)
            continue

        print("Trying IP: %s" % host_ip)
        if isOpen(host_ip, PORT):
            print("%s open at: %s... Will show consolidated list at the end.." % (PORT,host_ip))
            ssh_host_list.append(host_ip)

    if ssh_host_list is not []:
        print("SSH ports open for: ", *ssh_host_list)
