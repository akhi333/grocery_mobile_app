#!/bin/bash

# Set Flutter path
export PATH="/home/runner/flutter/bin:$PATH"

# Add to PATH permanently for this session
echo 'export PATH="/home/runner/flutter/bin:$PATH"' >> ~/.bashrc

# Flutter precache to download necessary tools
flutter precache --no-web --no-macos --no-windows --no-linux --no-fuchsia --android