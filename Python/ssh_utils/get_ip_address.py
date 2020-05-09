import socket

import fcntl
import struct


def get_ip_address(ifname):
    """
    Reference: https://stackoverflow.com/a/24196955/2138524
    :param ifname: interface name
    :return: ip address for the interface
    """
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    ip_addr = socket.inet_ntoa(
                    fcntl.ioctl(
                        s.fileno(),
                        0x8915,  # SIOCGIFADDR
                        struct.pack('256s', ifname[:15]))[20:24])
    s.close()
    return ip_addr
