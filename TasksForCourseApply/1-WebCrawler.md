**Important.** For the android course, you are required to solve 1 of the 3 tasks given (You are not required to solve all of them). This is task1. 

### Make a simple website crawler
Have you grown tired of looking for stuff on websites and it simply seems that it is not there at all?  
You look and point and click and suddenly...someone skypes you the link. It was there all along, how could you miss it?.  

Today, you mark the end of this.

Write a simple web crawler, that receives a `URL` **as a command line parameter** and a `needle` to search for (also as CMD param).
`needle` is text, usually a sentence.

What should your crawler do:
- GET the contents of the URL received from the command line
- Check if the contents contain "needle"
- If they do, output the **URL that contains "needle"** and exit
- If they don't, **get all the links** from the URL given and repeat the algorithm.

Hints/tips:
- Use the java programming language.
- Use a networking library of your choosing (if you need one at all).
- **Don't go out of the website's scope** - if a link in `abv.bg` points to google, well, don't follow google, please... 
- **Don't visit the same URL twice** 
- **Use regular expressions** for getting links. 
- Do not worry about links like `<a href=#>Useless link</a>` or javascript links. We won't be testing those.
- Be prepared to **handle broken links**. Your program should not crash merely because of one broken link.
- **If you are not comfortable with regular expressions, you can do it with clever string matching. It will be harder though :(**
- Use small websites for testing. For example, http://ebusiness.free.bg is one site you can use. It has very, very few links. (Search for the word 'Револвираща'.)
- Do not test on large websites ([9gag](http://9gag.com)), important websites (due to load) ([FMI](http://fmi.uni-sofia.bg)), or websites running on a raspberri Pi in Australia.

Example usages/tests:
```java
	WebCrawler crawler = new WebCrawler();

	URI startLocation = new URI("http://ebusiness.free.bg");
	URI link = crawler.crawl(startLocation, "Револвираща"); 
	System.out.println("result :" + link.toString()); //=> http://ebusiness.free.bg/cards_bank_cards.html
        ....
	startLocation = new URI("http://blog.hackbulgaria.com");
	link = crawler.crawl(startLocation,
			"Като страничен ефект, особено при момчетата, може да бъде бързо-растяща брада.");

	System.out.println("result :" + link.toString()); // => http://blog.hackbulgaria.com/fall-of-the-hackers/
        ....
	startLocation = new URI("http://fmi.wikidot.com");
	link = crawler.crawl(startLocation, "Докажете, че:");

	System.out.println("result :" + link.toString()); // => http://fmi.wikidot.com/anal-examination-1
```

##### Bonus points (not mandatory):
- Retain the full path to the result link, and not just the end link. See the example below.
```java
URI startLocation = new URI("http://ebusiness.free.bg");
	List<URI> path = crawler.crawl(startLocation, "Револвираща"); 
	System.out.println("result :" + path.toString()); //=> http://ebusiness.free.bg/cards_bank_cards.html // => http://ebusiness.free.bg, http://ebusiness.free.bg/index.html, http://ebusiness.free.bg/cards_bank_cards.html
```
- Add parallelisation optimazation. Work on several threads to achieve performance boost. We will be really pleased to see a multithreaded solution! 


