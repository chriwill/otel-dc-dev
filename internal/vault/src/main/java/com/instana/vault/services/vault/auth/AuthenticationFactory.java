/*
 * IBM Confidential
 * Copyright IBM Corp. 2024
 */

package com.instana.vault.services.vault.auth;

import com.instana.vault.VaultServiceConfig;
import com.instana.vault.services.vault.auth.strategy.VaultAuthenticationStrategy;
import com.instana.vault.services.vault.auth.strategy.TokenAuthenticationStrategy;
import com.instana.vault.services.vault.util.Constant;

import java.util.ArrayList;
import java.util.Map;

public class AuthenticationFactory {

    private AuthenticationFactory() {
        //Private Constructor
    }

    public static VaultAuthenticationStrategy getVaultAuthStrategyFromConfig(VaultServiceConfig vaultServiceConfig) {
        Map<String, Object> authConfig = vaultServiceConfig.getAuthConfig();
        String authType = new ArrayList<>(authConfig.keySet()).get(0);
        return getVaultAuthStrategy(authType, authConfig);
    }

    public static VaultAuthenticationStrategy getVaultAuthStrategy(String authType, Map<String, Object> authConfig) {
        VaultAuthenticationStrategy vaultAuthenticationStrategy = null;
        switch (authType) {
            case Constant.TOKEN:
                vaultAuthenticationStrategy = new TokenAuthenticationStrategy((String) authConfig.get(authType));
                break;
            //will be adding other cases for alternate auth strategies.
            default:

        }
        return vaultAuthenticationStrategy;
    }
}
