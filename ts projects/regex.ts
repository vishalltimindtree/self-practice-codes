// /regularExpression/
// [abc]	Find any character between the brackets
// [^abc]	Find any character NOT between the brackets
// [0-9]	Find any character between the brackets (any digit)
// [^0-9]	Find any character NOT between the brackets (any non-digit)
// (x|y)	Find any of the alternatives specified
// /g	Perform a global match (find all)
// /i	Perform case-insensitive matching
// .	Find a single character, except newline or line terminator
// \w	Find a word character-[a-zA-z]
// \W	Find a non-word character[^a-zA-z]
// \d	Find a digit[0-9]
// \D	Find a non-digit character[^0-9]
// \s	Find a whitespace character
// \S	Find a non-whitespace character
// \b	Find a match at the beginning/end of a word, beginning like this: \bHI, end like this: HI\b
// \B	Find a match, but not at the beginning/end of a word
// \0	Find a NULL character
// \n	Find a new line character
// \f	Find a form feed character
// \r	Find a carriage return character
// \t	Find a tab character
// \v	Find a vertical tab character

// Quantifiers
// [a-zA-Z]*
// n+	Matches any string that contains at least one n
// n*	Matches any string that contains zero or more occurrences of n
// n?	Matches any string that contains zero or one occurrences of n
// n{X}	Matches any string that contains a sequence of X n's
// n{X,Y}	Matches any string that contains a sequence of X to Y n's
// n{X,}	Matches any string that contains a sequence of at least X n's
// n$	Matches any string with n at the end of it
// ^n	Matches any string with n at the beginning of it
// ?=n	Matches any string that is followed by a specific string n
// ?!n	Matches any string that is not followed by a specific string n



// The regular expression /^[^\s@]+@[^\s@]+\.[^\s@]+$/ is used to validate email addresses. Here's a detailed breakdown of each component:

// ^: Asserts the start of a string, ensuring the pattern starts matching from the beginning of the input.

// [^\s@]+: This part ensures that the local part of the email address (before the @ symbol) does not contain whitespace (\s) or the @ symbol (@). Here's what each component means:

// [ ]: Denotes a character set.
// ^: Inside a character set, ^ negates the set, meaning it matches any character not listed.
// \s: Matches any whitespace character (spaces, tabs, line breaks).
// @: Matches the literal @ symbol.
// +: Ensures that one or more of the preceding characters or sets must occur.
// So, [^\s@]+ matches one or more characters that are not whitespace or @.

// @: Matches the literal @ symbol.

// [^\s@]+: Similar to the first part, this ensures that the domain part of the email address (after the @ symbol) does not contain whitespace or another @ symbol.

// \.: Matches a literal dot (.). The backslash (\) is used to escape the dot because in regular expressions, a dot matches any character unless escaped.

// [^\s@]+: Matches one or more characters that are not whitespace or @. This ensures that the top-level domain (TLD) part of the email address (e.g., .com, .org) does not contain whitespace or @.

// $: Asserts the end of a string, ensuring the pattern matches all the way to the end of the input.

// Explanation:
// This regular expression ensures that the email address:
// Starts with one or more characters that are not whitespace or @.
// Is followed by an @ symbol.
// Follows with one or more characters that are not whitespace or @ (the domain part).
// Includes a dot (.).
// Ends with one or more characters that are not whitespace or @ (the TLD part).





// The regular expression /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/ is used to validate a password that meets specific criteria. Let's break down what each part of the regex does:

// ^: Asserts the start of a string, ensuring the pattern starts matching from the beginning of the input.

// (?=.*[a-z]): Positive lookahead assertion. This ensures that the string contains at least one lowercase letter ([a-z]).

// (?=.*[A-Z]): Positive lookahead assertion. This ensures that the string contains at least one uppercase letter ([A-Z]).

// (?=.*\d): Positive lookahead assertion. This ensures that the string contains at least one digit (\d).

// (?=.*[!@#$%^&*]): Positive lookahead assertion. This ensures that the string contains at least one special character from the set [!@#$%^&*].

// [A-Za-z\d!@#$%^&*]{8,}: Matches the actual characters of the password:

// [A-Za-z\d!@#$%^&*]: Allowed characters in the password are letters (both uppercase and lowercase), digits, and the specified special characters.
// {8,}: Ensures that there are at least 8 characters in total.
// $: Asserts the end of a string, ensuring the pattern matches all the way to the end of the input