import re

f = open('template.html', 'r')

insertRegex = "^\s*<!-- TEMPLATE -->"

for line in f:
    if(re.match(insertRegex, line)):
       print "[ insertComponent ]"
    else:
       print line,
