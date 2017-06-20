package pl.ovoo.ss7.wrapper.common.telestax;

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
