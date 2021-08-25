/**
 * 
 */

package de.intellinet.ausbildung.rest.restkundenportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * @author ahmalk
 *
 * @since 04.05.2021
 */
@RestController
@RequestMapping("/hallo")
public class HalloController {

  
    @RequestMapping("/")
    public String m() {
        return String.format("Hallo bei ersten springBoot App.");
    }

    @GetMapping("/{name}")
    public String greetingWithName(@PathVariable String name) {
        return String.format("Hallo %s bei ersten springBoot App.", name);
    }

}
