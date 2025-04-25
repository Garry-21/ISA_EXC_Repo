from cryptography.fernet import Fernet

key = Fernet.generate_key()
cipher_suite = Fernet(key)

plain_text = "This is a secret message"
cipher_text = cipher_suite.encrypt(plain_text.encode())

decrypted_text = cipher_suite.decrypt(cipher_text).decode()

print("\nAES (via Fernet):")
print("Key:", key.decode())
print("Encrypted:", cipher_text.decode())
print("Decrypted:", decrypted_text)
