package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.RoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;

/**
 * Created by karolsimka on 06.06.17.
 */
public class TxSendRoutingInfoResponseWrapper implements SendRoutingInfoResponseWrapper {

    private transient IMSIAddressWrapper imsiAddressWrapper = null;
    private transient RoutingInfoWrapper roamingAddresWrapper = null;

    private IMSI imsi;

    private RoutingInfo roamingAddress;

    public TxSendRoutingInfoResponseWrapper() {
        super();
    }

    @Override
    public IMSIAddressWrapper getImsi() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    public void setImsi(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddressWrapper = null;
        } else {
            TxIMSIAddressWrapper txImsi = (TxIMSIAddressWrapper) imsi;
            this.imsi = txImsi.getTxImsi();
            this.imsiAddressWrapper = txImsi;
        }
    }

    @Override
    public RoutingInfoWrapper getRoutingInfo() {
        if (this.roamingAddresWrapper == null && this.roamingAddress != null) {
            this.roamingAddresWrapper = new TxRoutingInfoWrapper(roamingAddress);
        }
        return this.roamingAddresWrapper;
    }

    public void setRoutingInfo(RoutingInfoWrapper routingInfo) {
        if (routingInfo == null) {
            this.roamingAddress = null;
            this.roamingAddresWrapper = null;
        } else {
            TxRoutingInfoWrapper txRoutingInfo = (TxRoutingInfoWrapper) routingInfo;
            MAPParameterFactory factory = new MAPParameterFactoryImpl();

            ISDNAddressString roamingNumber = factory.createISDNAddressString(
                    AddressNature.getInstance(txRoutingInfo.getNatureOfAddress().getValue()),
                    NumberingPlan.getInstance(txRoutingInfo.getNumberingPlan().getValue()),
                    txRoutingInfo.getRoamingNumber());
            this.roamingAddresWrapper = txRoutingInfo;
            this.roamingAddress = factory.createRoutingInfo(roamingNumber);
        }
    }

    public RoutingInfo getTxRoamingAddress() {
        return roamingAddress;

    }

    public void setTxRoamingAddress(RoutingInfo  roamingAddress) {
        this.roamingAddress = roamingAddress;
        this.roamingAddresWrapper = null;
    }

    public IMSI getTxImsi() {
        return this.imsi;
    }

    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
    }

    @Override
    public String toString() {
        return "TxSendRoutingInfoResponseWrapper [imsi=" + imsi + ", roamingAddress=" + roamingAddress + "]";
    }

}
