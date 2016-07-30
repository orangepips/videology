import random

def main():
    a = set([random.randint(0, 10) for n in range(random.randint(5, 10))])
    b = set([random.randint(0, 10) for n in range(random.randint(5, 10))])

    print "a:\t" + str(a)
    print "b:\t" + str(b)
    print ""
    print "All elements present in both lists (elements must be present in list A and list B)"
    print a.intersection(b)
    print ""
    print "All elements present in exactly one list, but not the other (""in A but not in B"" as well as ""in B but not in A"")"
    print set(list(a.difference(b)) + list(b.difference(a)))
    print ""
    print "All elements present in any list, but discarding duplicates"
    print set(list(a) + list(b))


    return

if __name__ == "__main__":
    main()
