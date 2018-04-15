import socket


def isOpen(ip, port):
    """
    Taken mostly from: http://snipplr.com/view/19639/test-if-an-ipport-is-open/
    Added socket timer from my side that's all
    :param ip: IP of the host to test if port is open
    :param port: duh!
    :return: return true if the port is open in the host, else false
    """
    thissocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    thissocket.settimeout(1)
    try:
        thissocket.connect((ip, int(port)))
        thissocket.shutdown(2)
        thissocket.close()
        return True
    except:
        thissocket.close()
        return False

