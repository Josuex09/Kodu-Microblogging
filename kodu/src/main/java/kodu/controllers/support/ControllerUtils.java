package kodu.controllers.support;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class ControllerUtils {
	
    public static String getCurrentUsername(Principal principal) {
        return ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
    }
}
