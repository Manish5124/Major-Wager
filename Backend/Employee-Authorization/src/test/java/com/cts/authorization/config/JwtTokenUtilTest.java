package com.cts.authorization.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.authorization.model.MyUserDetails;
import com.cts.authorization.model.User;
import io.jsonwebtoken.Claims;

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
    @Disabled("TODO: Complete this test")
    void testGetUsernameFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:46)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:39)
        //       at com.cts.authorization.config.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.getUsernameFromToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#getExpirationDateFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExpirationDateFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:46)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:39)
        //       at com.cts.authorization.config.JwtTokenUtil.getExpirationDateFromToken(JwtTokenUtil.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.getExpirationDateFromToken("ABC123");
    }

    /**
     * Method under test: {@link JwtTokenUtil#getClaimFromToken(String, Function)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetClaimFromToken() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: reactor.netty.http.server.HttpServer
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

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
    @Disabled("TODO: Complete this test")
    void testGenerateToken() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        jwtTokenUtil.generateToken(new MyUserDetails(new User("janedoe", "iloveyou")));
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.cts.authorization.model.User.getUserName()" because "this.user" is null
        //       at com.cts.authorization.model.MyUserDetails.getUsername(MyUserDetails.java:32)
        //       at com.cts.authorization.config.JwtTokenUtil.generateToken(JwtTokenUtil.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.generateToken(new MyUserDetails(null));
    }

    /**
     * Method under test: {@link JwtTokenUtil#generateToken(UserDetails)}
     */
    @Test
    void testGenerateToken3() {
        User user = mock(User.class);
        when(user.getUserName()).thenReturn("janedoe");
        jwtTokenUtil.generateToken(new MyUserDetails(user));
        verify(user).getUserName();
    }

    /**
     * Method under test: {@link JwtTokenUtil#validateToken(String, UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:46)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:39)
        //       at com.cts.authorization.config.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:29)
        //       at com.cts.authorization.config.JwtTokenUtil.validateToken(JwtTokenUtil.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.validateToken("ABC123", new MyUserDetails(new User("janedoe", "iloveyou")));
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
        //       at com.cts.authorization.config.JwtTokenUtil.getAllClaimsFromToken(JwtTokenUtil.java:46)
        //       at com.cts.authorization.config.JwtTokenUtil.getClaimFromToken(JwtTokenUtil.java:39)
        //       at com.cts.authorization.config.JwtTokenUtil.getUsernameFromToken(JwtTokenUtil.java:29)
        //       at com.cts.authorization.config.JwtTokenUtil.validateToken(JwtTokenUtil.java:72)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtTokenUtil.validateToken("ABC123", new MyUserDetails(mock(User.class)));
    }
}

