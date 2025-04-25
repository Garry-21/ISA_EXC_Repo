def caesar_encrypt(text, shift):
    result = ""
    for char in text:
        if char.isalpha():
            offset = 65 if char.isupper() else 97
            result += chr((ord(char) - offset + shift) % 26 + offset)
        else:
            result += char
    return result

def caesar_decrypt(cipher, shift):
    return caesar_encrypt(cipher, -shift)

plain_text = "HelloWorld"
shift = 3

encrypted = caesar_encrypt(plain_text, shift)
decrypted = caesar_decrypt(encrypted, shift)

print("Caesar Cipher:")
print("Encrypted:", encrypted)
print("Decrypted:", decrypted)
