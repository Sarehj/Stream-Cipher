# Stream-Cipher

## Purpose
The purpose of this project is to develop a practical encryption application using symmetric encryption algorithms. The project involves implementing a stream cipher that encrypts and decrypts data, designing a custom pseudo-random number generator (PRNG), and evaluating its performance. Additionally, the project includes creating a custom implementation of the RC4 stream cipher, which is a widely-used encryption algorithm.

## Overview
This project is structured into three key tasks:

#### Task 1: Simple Synchronous Stream Cipher
The cipher takes a plaintext message and an encryption key, and outputs a ciphertext. The cipher operates by generating a stream of pseudo-random bytes and performing a byte-wise XOR operation with the plaintext or ciphertext to encrypt or decrypt the data.


#### Task 2: Custom Pseudo-Random Number Generator (PRNG)
The second task focuses on designing and implementing a custom PRNG by extending Java’s Random class. This custom PRNG is based on the Linear Congruential Generator (LCG) algorithm, with carefully chosen parameters (like modulus, multiplier, and increment) to maximize the period of the generated sequence. The custom PRNG is then integrated into the stream cipher from Task 1.

#### Task 3: RC4 Stream Cipher Implementation
The final task involves implementing the RC4 stream cipher algorithm from scratch. RC4 is a widely-used stream cipher known for its simplicity and speed. The implementation ensures compatibility with standard RC4 outputs, reinforcing the understanding of stream ciphers and providing practical experience with cryptographic algorithms that are used in real-world applications.


## Execution
Run the stream cipher with the required arguments:

`java StreamCipher <key> <infile> <outfile>`

* key: Encryption key provided as a decimal integer.
* infile: The input file containing the plaintext (for encryption) or ciphertext (for decryption).
* outfile: The output file where the resulting ciphertext or plaintext will be saved.
