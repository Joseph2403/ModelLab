import nltk
from nltk.corpus import stopwords
from collections import Counter

nltk.download('punkt', quiet=True)
nltk.download('stopwords', quiet=True)


def top_50_frequent_words(text):
    tokens = nltk.word_tokenize(text.lower())
    stop_words = set(stopwords.words('english'))
    filtered_tokens = [
        word for word in tokens if word.isalpha() and word not in stop_words]
    word_freq = Counter(filtered_tokens)
    return word_freq.most_common(50)


sample_text = """In today's fast-paced world, technology plays a vital role in shaping how we communicate, work, and live.
The rise of artificial intelligence and machine learning has revolutionized industries and transformed the
way businesses operate. As we continue to innovate, it is essential to balance technological advancements
with ethical considerations to ensure a future that benefits all of humanity."""

top_words = top_50_frequent_words(sample_text)
print("Top 50 most frequent words (not stopwords):")
for word, freq in top_words:
    print(f"{word}: {freq}")
