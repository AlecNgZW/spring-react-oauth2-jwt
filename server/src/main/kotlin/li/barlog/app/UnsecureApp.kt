@file:JvmName("UnsecureApp")

package li.barlog.app

import li.barlog.app.config.AuthenticationConfig
import li.barlog.app.config.SecurityConfig
import li.barlog.app.config.oauth.AuthorizationServerConfig
import li.barlog.app.config.oauth.ResourceServerConfig
import li.barlog.app.security.OAuth2AccessConfirmationController
import li.barlog.app.security.OAuth2LogoutSuccessHandler
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@EnableAutoConfiguration(
    exclude = arrayOf(
        OAuth2AutoConfiguration::class,
        SecurityAutoConfiguration::class,
        ManagementWebSecurityAutoConfiguration::class
    )
)
@ComponentScan(
    basePackages = arrayOf("li.barlog.app"),
    excludeFilters = arrayOf(
        ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            classes = arrayOf(
                App::class,
                SecurityConfig::class,
                AuthenticationConfig::class,
                AuthorizationServerConfig::class,
                ResourceServerConfig::class,
				OAuth2LogoutSuccessHandler::class,
				OAuth2AccessConfirmationController::class
            )
        )
    )
)
open class UnsecureApp {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            SpringApplicationBuilder(UnsecureApp::class.java)
                .registerShutdownHook(true).run(*args)
        }
    }
}