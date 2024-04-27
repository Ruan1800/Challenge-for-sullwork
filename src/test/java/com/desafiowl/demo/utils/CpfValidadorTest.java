package com.desafiowl.demo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidadorTest {

    @Test
   public void VerifyIfcpfValid(){
        assertFalse(CpfValidador.isValidCpf("123.456.78-00"));
    }
    @Test
    public void VerifyIsValidCpf_Cpfwithlettrs() {
        assertFalse(CpfValidador.isValidCpf("ABC12345678"));
    }
}