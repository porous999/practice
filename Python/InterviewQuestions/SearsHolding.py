def waitingTime(tickets, p):
    counter = 0
    total_queue = len(tickets)
    i = 0
    while tickets[p] != 0:
        i %= total_queue
        if tickets[i] != 0:
            tickets[i] -= 1
            counter += 1
        i += 1

    return counter


def maxTokens(friends_nodes, friends_from, friends_to, friends_weight):
    friendsToken = []

    '''
    for i in range(0, len(friends_from)):
        for j in range(0,len(friends_to)):
            if i == j:
                continue
            for k in range(0, len(friends_nodes)):
                friendsToken[i][j]
    '''


if __name__ == '__main__':
    print (waitingTime([2,6,3,4,5], 2))
    # print(maxTokens([1, 2, 3, 4], [1, 1, 2, 3], [2, 3, 3, 4], [1, 2, 1, 2]))
