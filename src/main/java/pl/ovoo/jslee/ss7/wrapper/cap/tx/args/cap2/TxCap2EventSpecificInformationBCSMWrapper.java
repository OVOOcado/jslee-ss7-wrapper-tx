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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2;

import org.mobicents.protocols.ss7.cap.api.EsiBcsm.TBusySpecificInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxEventSpecificInformationBCSMWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2EventSpecificInformationBCSMWrapper;


/**
 * TxCap2EventSpecificInformationBCSMWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2EventSpecificInformationBCSMWrapper extends TxEventSpecificInformationBCSMWrapper implements Cap2EventSpecificInformationBCSMWrapper {

    /**
     * Instantiates a new tx cap2 event specific information bcsm wrapper.
     *
     * @param eventSpecificInformationSMS the event specific information sms
     */
    public TxCap2EventSpecificInformationBCSMWrapper(final EventSpecificInformationBCSM eventSpecificInformationSMS) {
        super(eventSpecificInformationSMS);
    }

    /**
     * The Class TxCap2TCalledPartyBusySpecificInfoWrapper.
     */
    public static class TxCap2TCalledPartyBusySpecificInfoWrapper extends TxTCalledPartyBusySpecificInfoWrapper implements Cap2TCalledPartyBusySpecificInfoWrapper {

        /**
         * Instantiates a new tx cap2 t called party busy specific info wrapper.
         *
         * @param tCalledPartyBusySpecificInfo the t called party busy specific info
         */
        public TxCap2TCalledPartyBusySpecificInfoWrapper(final TBusySpecificInfo tCalledPartyBusySpecificInfo) {
            super(tCalledPartyBusySpecificInfo);
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2EventSpecificInformationBCSMWrapper.Cap2TCalledPartyBusySpecificInfoWrapper#getCallForwardedPresent()
         */
        @Override
        public boolean getCallForwardedPresent() {
            return tCalledPartyBusySpecificInfo.getCallForwarded();
        }
    }
}
