def tower_of_hanoi(towers):
    if len(towers['source']) == 0:
        print ("GO away")
        return towers
    '''if (len(towers['temporary']) == 0):
        print("No buffer")
        return towers'''
    # print(towers['source'][1])
    towers['dest'].insert(towers['source'].pop(0))
    if len(towers['source']) != 0:
        towers['temporary'].insert(towers['source'].pop(0))

    if len(towers['temporary']) != 0:
        towers['dest'].insert(towers['temporary'].pop(0))

    if len(towers['source']) != 0:
        towers['dest'].insert(towers['temporary'].pop(0))

    return towers


if __name__ == '__main__':
    print("Getting to the Hanoi Towering!!")
    source_list = [1, 2, 3, 4, 5]  # put in any number of sorted elements

    # source_list, temporary_list, destination_list
    # towers = {"source": source_list, "temporary": list(), "dest": list()}
    #
    #  towers = towerofhanoi(towers)
    #  print (towers['dest'])
