# Based on tests below the decision point boils down to fast insert times or small memory footprint.
# The two candidate data structure options being a hashtable (a.k.a. dictionary, map) or a trie
# with the former being much faster to populate and the latter much more memory efficient. Note, no practical
# retrieval difference was noted, albeit depending on the character set of the data being stored or the hash function
# involved may impact that retrieval speed.
#
# The hashtable used is Python's built in dict while the trie is from https://github.com/kmike/datrie
#
# Benchmarks were done with the anacondas Python 2.7.8 distribution on a Macbook Pro OSX 10.9.5 2.7 GHz Intel Core i7
# 16 GB 1600 Mhz DDR3
#
# The following data gathering shows the different in population performance and memory consumption
#
# dictionary
#
# iterations|MBs|population secs|retrieval secs
# 100,000|27.93359375|3.8673|0.0000
# 200,000|57.7578125|7.9814|0.0000
# 300,000|75.63671875|11.7909|0.0000
# 400,000|117.453125|15.5348|0.0000
# 500,000|135.30078125|19.6350|0.0000
# 1,000,000|272.484375|38.6464|0.0000
#
# trie
#
# iterations|MBs|population secs|retrieval secs
# 100,000|17.7578125|9.3730|0.0000
# 200,000|34.9765625|43.6296|0.0000
# 300,000|45.21484375|97.1127|0.0000
# 400,000|65.10546875|149.0669|0.0000
# 500,000|73.0859375|193.6686|0.0000
# 1,000,000|175.06640625|381.6497|0.0000


import os
import datrie
import string
import random
import time

trie_characters = string.printable
last_full_name = u''

def full_name_gen():
    return ''.join(random.choice(trie_characters) for x in range(2, 15)) + ' ' \
        + ''.join(random.choice(trie_characters) for x in range(2, 15))

def phone_num_gen():
    return ''.join(random.choice(string.digits) for x in range(10))

def scrub(value):
    return unicode(filter(lambda x: x in trie_characters, value))

def memory_usage_psutil():
    # return the memory usage in MB
    import psutil
    process = psutil.Process(os.getpid())
    mem = process.get_memory_info()[0] / float(2 ** 20)
    return mem

def timeit(f):

    def timed(*args, **kw):

        ts = time.time()
        result = f(*args, **kw)
        te = time.time()

        #print 'func:%r args:[%r, %r] took: %2.4f sec' % \
        #      (f.__name__, args, kw, te-ts)
        print 'func:%r took: %2.4f sec' % (f.__name__, te-ts)
        return result

    return timed

@timeit
def populate(container, iterations):
    global last_full_name

    start = memory_usage_psutil()

    for index in range(0, iterations):
        full_name = full_name_gen()
        full_name = str(index) + full_name if index % 2 == 0 else full_name + str(index)
        full_name = scrub(full_name)
        phone_number = phone_num_gen()

        container[full_name] = phone_number

        if index % (iterations / 10) == 0:
            print str(index) + ':\t' + str(memory_usage_psutil() - start)

    last_full_name = full_name

    print 'Total Memory:\t' + str(memory_usage_psutil() - start)

@timeit
def retrieve(container):
    return container[last_full_name]

def main():
    # hashtable
    #container = {}
    
    # trie
    container = datrie.Trie(trie_characters)

    populate(container, 200000)
    print last_full_name + ':\t' + str(retrieve(container))

    return

if __name__ == "__main__":
    main()