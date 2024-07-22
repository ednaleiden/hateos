package com.hateos.repository;


import com.hateos.model.cuenta;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


/*@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CuentaRepositoryTest {


   @Autowired
    private  CuentaRepository cuentaRepository;

   @Test
   void testAgregarCuenta(){
       cuenta Cuenta = new cuenta(222,"24556");
       cuenta CuentaGuardada = cuentaRepository.save(Cuenta);


       Assertions.assertThat(CuentaGuardada).isNotNull();
       Assertions.assertThat(CuentaGuardada.getId()).isGreaterThan(0);
   }
}*/

