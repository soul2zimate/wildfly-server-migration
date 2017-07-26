/*
 * Copyright 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.migration.eap.task.subsystem.elytron;

import org.jboss.as.controller.PathAddress;
import org.jboss.as.controller.operations.common.Util;
import org.jboss.dmr.ModelNode;

/**
 * @author emmartins
 */
public class ProviderHttpServerMechanismFactoryAddOperation {
    private final PathAddress subsystemPathAddress;
    private final String providerHttpServerMechanismFactory;

    public ProviderHttpServerMechanismFactoryAddOperation(PathAddress subsystemPathAddress, String providerHttpServerMechanismFactory) {
        this.subsystemPathAddress = subsystemPathAddress;
        this.providerHttpServerMechanismFactory = providerHttpServerMechanismFactory;
    }

    public ModelNode toModelNode() {
         /*
              "operation" => "add",
            "address" => [
                ("subsystem" => "elytron"),
                ("provider-http-server-mechanism-factory" => "global")
            ]
             */
        final PathAddress pathAddress = subsystemPathAddress.append("provider-http-server-mechanism-factory", providerHttpServerMechanismFactory);
        final ModelNode operation = Util.createAddOperation(pathAddress);
        return operation;
    }
}
