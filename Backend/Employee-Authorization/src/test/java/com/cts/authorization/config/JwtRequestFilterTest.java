package com.cts.authorization.config;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.support.StandardServletEnvironment;

class JwtRequestFilterTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link JwtRequestFilter}
     *   <li>{@link JwtRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * </ul>
     */
    @Test
    void testConstructor() throws IOException, ServletException {
        JwtRequestFilter actualJwtRequestFilter = new JwtRequestFilter();
        MockHttpServletRequest request = new MockHttpServletRequest();
        actualJwtRequestFilter.doFilterInternal(request, new Response(), mock(FilterChain.class));
        Environment environment = actualJwtRequestFilter.getEnvironment();
        assertTrue(environment instanceof StandardServletEnvironment);
        String[] activeProfiles = environment.getActiveProfiles();
        assertEquals(0, activeProfiles.length);
        assertArrayEquals(new String[]{}, activeProfiles);
        Map<String, Object> systemProperties = ((StandardServletEnvironment) environment).getSystemProperties();
        assertEquals(66, systemProperties.size());
        Map<String, Object> systemEnvironment = ((StandardServletEnvironment) environment).getSystemEnvironment();
        assertEquals(43, systemEnvironment.size());
        assertTrue(((StandardServletEnvironment) environment).getConversionService() instanceof DefaultConversionService);
        String[] defaultProfiles = environment.getDefaultProfiles();
        assertEquals(1, defaultProfiles.length);
        assertArrayEquals(new String[]{"default"}, defaultProfiles);
        assertEquals("default", defaultProfiles[0]);
        assertEquals("17", systemProperties.get("java.specification.version"));
        MutablePropertySources propertySources = ((StandardServletEnvironment) environment).getPropertySources();
        assertEquals(4, propertySources.size());
        assertEquals("6", systemEnvironment.get("PROCESSOR_LEVEL"));
        String expectedString = Paths.get(System.getProperty("user.home"), "AppData", "Local").toString();
        assertEquals(expectedString, systemEnvironment.get("LOCALAPPDATA"));
        assertEquals("MANISH", systemEnvironment.get("USERDOMAIN_ROAMINGPROFILE"));
        assertEquals("off", systemProperties.get("kotlinx.coroutines.debug"));
        assertEquals("C:\\Program Files\\JetBrains\\IntelliJ IDEA 2022.1.3\\bin;", systemEnvironment.get("IntelliJ IDEA"));
        assertEquals("amd64", systemProperties.get("sun.cpu.isalist"));
        String expectedString1 = Paths
                .get(System.getProperty("user.home"), "AppData", "Roaming", "JetBrains", "IntelliJIdea2022.1", "plugins",
                        "diffblue-cover-ij", "META-INF", "cover-service-analyzer-2022.10.01.jar")
                .toString();
        assertEquals(expectedString1, systemProperties.get("cover.jar.path"));
        assertEquals(4L, propertySources.spliterator().getExactSizeIfKnown());
    }
}

