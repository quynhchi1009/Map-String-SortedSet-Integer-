# IndexText
Reference books usually have an index that notes the pages on which important words appear, so that you can quickly search for terms. In this task, I am to implement a class Index in the package index in such a way that it supports the creation of such an index. The class already created for this purpose contains two methods:
- public void addOccurrence(final String word, final int page) is to add an occurrence of a word on a page to the index, and
- public String getEntry(String word) is to add to a word an index entry of the form <word>: <page>, <page>, <page> shall be returned. If a word does not occur, the entry shall be of the form
<word>: ---

This means that the following code :
Index index = new Index(); 
index.addOccurrence("Rotational ellipsoid", 5); 
index.addOccurrence("Rotational ellipsoid", 5); 
// Multiple! 
index.addOccurrence("Paraboloid", 8); 
index.addOccurrence("Rotational ellipsoid", 8); 
index. addOccurrence("Paraboloid", 10); 
index.addOccurrence("Hyperboloid", 17); 
System.out.println(index.getEntry("Hyperboloid")); 
System.out.println(index.getEntry("Paraboloid")); 
System.out.println(index.getEntry("Rotational ellipsoid")); 
System.out.println(index.getEntry("Rhubarb"));

which should have the following output:
Hyperboloid: 17
paraboloid: 8, 10
rotational ellipsoid: 5, 8
Rhubarb: ---
