import binascii
xor_key=01101001
encoded = binascii.unhexlify('4344495e4c5148194d1b44441b444d755d1b5e42755e4219755943475a4619595e57')
decoded = ''.join(chr(b ^ xor_key) for b in encoded)
if decoded.isprintable():
    print(xor_key, decoded)
