package tfidf;

public class Stemming {

	public static String stem(String token) {
		final Stemmer stemmer = new Stemmer();

		final char[] charArray = token.toCharArray();
		for (final char element : charArray) {
			stemmer.add(element);
		}

		// Run stemming
		stemmer.stem();

		// Get the stemmed word and map its occurence
		return stemmer.toString();
	}
}