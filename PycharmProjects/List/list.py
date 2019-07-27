
mylist = [1,2,3,44]
print(mylist[0])
mylist = ['saikat sen','a',123123]
print(mylist[0][1])
fuck = [0,1,2,3,4,5,6,7,8,9]

ans = fuck[2:5]
print(ans)
ans = fuck[1:]
print(ans)

ans = fuck[:-1]
print(ans)

ans = fuck[-1:]
print(ans)

ans = fuck[2:4]+fuck[5:7]
print(ans)

#here add some element in an index position
ans[2:2] = ["saikat","rabbi",69]
print(ans)

myarray = ['a','b','c','d','e','f']
ans = myarray[:]
del ans[1:4]
print(ans)

ans = myarray[:]
del ans[1]
ans[1:4] =[]
print(ans)

ans = myarray[:]
ans.sort();
print(ans)

ans.reverse();
print(ans)

array = [ 2**x for  x in range(10) if(x>2)]
print(array)

ans = [[1,2,3,4],[999,8888],[5,6],[0000,1111]]
print(ans[0][3])
ans.append(['saikat','sen'])
print(ans[4][1])
ans[2] = ['dada','is']
print(ans[2][1])

print("He said, \"What\'s there?\"")
print( "|{:<10}|{:^10}|{:>10}|".format('butter','bread','ham'))