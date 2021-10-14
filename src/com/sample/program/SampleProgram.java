package com.sample.program;

import java.util.stream.Stream;

class SampleProgram {

  private final ProductVerifier verifier;

  ProductionLineTester(ProductVerifier verifier) {
    this.verifier = verifier;
  }

  ProductLineTestReport test(Stream<Product> products) {
    
    verifier.verify()

    return null;
  }

}
