/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2EventSpecificInformationBCSMWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxEventSpecificInformationBCSMWrapper;

/**
 * TxCap2EventSpecificInformationBCSMWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2EventSpecificInformationBCSMWrapper extends TxEventSpecificInformationBCSMWrapper implements Cap2EventSpecificInformationBCSMWrapper {

    public TxCap2EventSpecificInformationBCSMWrapper(final EventSpecificInformationBCSM eventSpecificInformationSMS) {
        super(eventSpecificInformationSMS);
    }

    public static class TxCap2TCalledPartyBusySpecificInfoWrapper extends TxTCalledPartyBusySpecificInfoWrapper implements Cap2TCalledPartyBusySpecificInfoWrapper {

        public TxCap2TCalledPartyBusySpecificInfoWrapper(final TBusySpecificInfo tCalledPartyBusySpecificInfo) {
            super(tCalledPartyBusySpecificInfo);
        }

        @Override
        public boolean getCallForwardedPresent() {
            return tCalledPartyBusySpecificInfo.getCallForwarded();
        }
    }
}
