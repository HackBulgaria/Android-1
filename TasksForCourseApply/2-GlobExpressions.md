### Globs 
[Globs](http://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob) are like regular expressions, but far simpler.  
Note: there are different definions of a *glob*. We will use a subset of the link above.

Globs are usually used in path pattern matching (`ls *.mp3` to see what I mean. There should be an equivalent in the Windows shell/powershell as well).
Here are some example of globs:
- `*.html` - every file in **the current folder**, whose name ends in .html
- `*?.java` - every file with at least 1 character, ending in .java
- `**.java` - Any .java file in **either the current folder or any descendent of the current folder**.
- `*List*.java` - Any file that contains a `List` and ends with `.java`
- `Di{nko,mitur}` - Matches either `Dinko` or `Dimitur`
- `Main.java` - an exact match, matches only `Main.java`.

A bit more formal:
- any literal character (for example `a`) means literal(exact) match.
- a `?` character means **exactly one character**
- a `*` character means **zero or more characters**, but **do not cross directory boundaries**.
- a `**` character means **zero or more characters** and you **are allowed to cross directory boundaries**
- a `{abc,def}` matches only if there is either a `abc` or `def` string.


##### Write a Glob class
Create a `Glob` class that tells us whether an input matches a glob.
Implement a `boolean matches(String input)` instance method, which tells us whether the input given matches the glob expression of the instance.

Example usages/tests of your class:
```java
	Glob glob = Glob.compile("abc?");
	assertFalse(glob.matches("abc")); //false => ? means exactly one character
	assertTrue(glob.matches("abcd")); //true
	assertFalse(glob.matches("abcde"));
```

```java
	Glob glob2 = Glob.compile("a*d");
	assertTrue(glob2.matches("abcd"));
	assertTrue(glob2.matches("abcujawiohtguahwuthawitthawuithawuthaithawtawutd"));
	assertFalse(glob2.matches("abcdej"));
	assertFalse(glob2.matches("abcujawiohtguahwuthawitthawuithawuthaithawtawutd1"));
```

```java
	Glob glob3 = Glob.compile("*.html");
	assertTrue(glob3.matches("index.html"));
	assertFalse(glob3.matches("index.htm")); //false - missing 'l'
	assertFalse(glob3.matches("directory/index.html")); //false - crossing directory boundaries
```
```java
	Glob glob4 = Glob.compile("Di{nko,mitur}");
	assertTrue(glob4.matches("Dimitur"));
	assertTrue(glob4.matches("Dinko"));
	assertFalse(glob4.matches("Divna"));
```
```java
	Glob glob5 = Glob.compile("/home/georgi/**index.html");
	assertTrue(glob5.matches("/home/georgi/testme/testme2/index.html"));
	assertTrue(glob5.matches("/home/georgi/testme/testme2/testME_index.html"));
	assertFalse(glob5.matches("/home/index.html"));
```


##### Instructions
- Use the java programming language. Library usage is permitted, though not necessary.
- It is not mandatory to implement all of operators given (`?`,`**`, and so on). We are perfectly happy to check (working) solutions with not all of the operators implemented. However -  the more you implement, the better score you get :)
- Your `Glob` class should be public (for the sake of automated testing).
- A test-driven approach for this task will help you a lot!
