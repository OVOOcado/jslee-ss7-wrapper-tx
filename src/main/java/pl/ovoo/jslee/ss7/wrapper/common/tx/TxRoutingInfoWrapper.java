/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.common.tx;

import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.ss7.wrapper.common.args.RoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper.Nature;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper.NumberingPlan;

/**
 * Created by karolsimka on 06.06.17.
 */
public class TxRoutingInfoWrapper implements RoutingInfoWrapper {
    private final RoutingInfo routingInfo;

    public TxRoutingInfoWrapper(final RoutingInfo routingInfo) {
        this.routingInfo = routingInfo;
    }

    @Override
    public String getRoamingNumber() {
        if (routingInfo.getRoamingNumber() != null) {
            return routingInfo.getRoamingNumber().getAddress();
        }
        return null;
    }

    @Override
    public NumberingPlan getNumberingPlan() {
        if (routingInfo.getRoamingNumber() != null && routingInfo.getRoamingNumber().getNumberingPlan() != null) {
            return NumberingPlan.valueOf(routingInfo.getRoamingNumber().getNumberingPlan().getIndicator());
        }
        return null;
    }

    @Override
    public Nature getNatureOfAddress() {
        if (routingInfo.getRoamingNumber() != null && routingInfo.getRoamingNumber().getAddressNature() != null) {
            return Nature.valueOf(routingInfo.getRoamingNumber().getAddressNature().getIndicator());
        }
        return null;
    }

    public RoutingInfo getTxRoutingInfo() {
        return routingInfo;
    }

}
