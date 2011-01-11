package org.fluttercode.datafactory.impl;

import org.fluttercode.datafactory.ContentDataValues;

public class DefaultContentDataValues implements ContentDataValues {

	public static String[] words = { "throw", "ball", "hat", "red", "worn",
			"list", "words", "computer", "in", "out", "hot", "cold", "warp",
			"speed", "captain", "assert", "hold", "room", "ship", "lost", "is",
			"television", "show", "about", "plane", "crash", "island",
			"monster", "trees", "banging", "smoke", "where", "are", "we",
			"was", "asked", "no", "rescue", "came", "build", "fire", "waited",
			"days", "moved", "to", "caves", "found", "with", "ghost", "dad",
			"in", "white", "rabbit", "lock", "discovered", "hatch", "with",
			"boon", "secretly", "hid", "it", "while", "trying", "to", "open",
			"it", "until", "sidekick", "died", "as", "sacrifice", "island",
			"demanded", "many", "had", "dreams", "or", "visions", "others",
			"came", "took", "people", "who", "are", "they", "what", "do",
			"they", "want", "light", "came", "on", "through", "window",
			"leader", "is", "a", "good", "man", "numbers", "in", "room",
			"enter", "keys", "computer", "end", "of", "world", "wicket",
			"magnetic", "pull", "shepherd", "always", "wrong", "much",
			"suspense", "what", "to", "do", "when", "it", "ends", "I", "will",
			"have", "to", "find", "something", "else", "to", "pique", "my",
			"interest", "or maybe", "write", "lots", "of", "code", "probably",
			"should", "have", "generated", "this", "text", "automatically",
			"so", "will", "from", "the", "web", "ending", "badly", "library",
			"handled", "books", "constantly", "headphones" };

	private static String[] businessTypes = { "Furnishings", "Bakery",
			"Accounting", "Textiles", "Manufacturing", "Industries",
			"Pro Services", "Landscaping", "Realty", "Travel",
			"Medical supplies", "Office supplies", "Insurance", "Software",
			"Motors", "Cafe", "Services", "Gymnasium", "Motor Services",
			"Signs", "Development","Studios","Engineering","Development" };

	private static String[] emailHosts = { "gma1l", "hotma1l", "yah00",
			"somema1l", "everyma1l", "ma1lbox", "b1zmail", "ma1l2u" };

	private static String[] tlds = { "org", "net", "com", "biz", "us", "co.uk" };

	public String[] getWords() {
		return words;
	}

	public String[] getBusinessTypes() {
		return businessTypes;
	}

	public String[] getEmailHosts() {
		return emailHosts;
	}

	public String[] getTlds() {
		return tlds;
	}

}
