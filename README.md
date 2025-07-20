🔐 Password Analyzer (Java)

A simple Java tool to analyze the strength of a password.


---

✅ Features

Checks for:

Minimum length (≥8)[as per OWASP]
\\\\\{
Weak	< 8 chars	Or missing uppercase/lowercase/digits/symbols
Medium	≥ 8 chars	Has all types but not long enough or includes weak patterns
Strong	≥ 12 chars	All character types + no common patterns + good length
}/////

Uppercase, lowercase, digits, special characters
Common weak patterns (like 123, password, qwerty)
Classifies password as Weak, Medium, or Strong
Suggests improvements if weak

