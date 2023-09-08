package com.cts.authorization.config;

import com.cts.authorization.model.MyUserDetails;
import com.cts.authorization.model.User;
import io.jsonwebtoken.Claims;

import java.util.Date;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtTokenUtil.class})
@ExtendWith(SpringExtension.class)
class JwtTokenUtilTest {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * Method under test: {@link JwtTokenUtil#getUsernameFromToken(String)}
     */
    @Test
    void testGetUsernameFromToken() {
        // Arrange
        // TODO: Populate arranged inputs
        String token = "";

        // Act
        String actualUsernameFromToken = this.jwtTokenUtil.getUsernameFromToken(token);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtTokenUtil#getUsernameFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsernameFromToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:60)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:50)
        //       at com.cts.authorization.config.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:32)
        //   In order to prevent getUsernameFromToken(String)
        //   from throwing MalformedJwtException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getUsernameFromToken(String).
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.getUsernameFromToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#getExpirationDateFromToken(String)}
     */
    @Test
    void testGetExpirationDateFromToken() {
        // Arrange
        // TODO: Populate arranged inputs
        String token = "";

        // Act
        Date actualExpirationDateFromToken = this.jwtTokenUtil.getExpirationDateFromToken(token);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtTokenUtil#getExpirationDateFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExpirationDateFromToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:60)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:50)
        //       at com.cts.authorization.config.JwtTokenUtil.getExpirationDateFromToken(JwtTokenUtil.java:40)
        //   In order to prevent getExpirationDateFromToken(String)
        //   from throwing MalformedJwtException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getExpirationDateFromToken(String).
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.getExpirationDateFromToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#getClaimFromToken(String, Function)}
     */
    @Test
    void testGetClaimFromToken() {
        // Arrange
        // TODO: Populate arranged inputs
        String token = "";
        Function<Claims, Object> claimsResolver = null;

        // Act
        Object actualClaimFromToken = this.jwtTokenUtil.getClaimFromToken(token, claimsResolver);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    void testGenerateToken() {
        // Arrange
        // TODO: Populate arranged inputs
        UserDetails userDetails = null;

        // Act
        String actualGenerateTokenResult = this.jwtTokenUtil.generateToken(userDetails);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken2() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        jwtTokenUtil.generateToken(new MyUserDetails(new User()));
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.cts.authorization.config.JwtTokenUtil.generateToken(JwtTokenUtil.java:79)
        //   In order to prevent generateToken(UserDetails)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   generateToken(UserDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.generateToken(null);
    }

    /**
     * Method under test: {@link JwtTokenUtil#validateToken(String, UserDetails)}
     */
    @Test
    void testValidateToken() {
        // Arrange
        // TODO: Populate arranged inputs
        String token = "";
        UserDetails userDetails = null;

        // Act
        Boolean actualValidateTokenResult = this.jwtTokenUtil.validateToken(token, userDetails);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtTokenUtil#validateToken(String, UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:60)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:50)
        //       at com.cts.authorization.config.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:32)
        //       at com.cts.authorization.config.JwtTokenUtil.validateToken(JwtTokenUtil.java:101)
        //   In order to prevent validateToken(String, UserDetails)
        //   from throwing MalformedJwtException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   validateToken(String, UserDetails).
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.validateToken("ABC123", new MyUserDetails(new User()));
    }
}

