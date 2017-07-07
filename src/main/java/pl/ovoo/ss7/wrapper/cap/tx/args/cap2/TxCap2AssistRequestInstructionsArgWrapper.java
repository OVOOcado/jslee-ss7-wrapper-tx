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

package pl.ovoo.ss7.wrapper.cap.tx.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.IPSSPCapabilities;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2AssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2IPSSPCapabilitiesWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxAssistRequestInstructionsArgWrapper;

/**
 * TxAssistRequestInstructionsArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2AssistRequestInstructionsArgWrapper extends TxAssistRequestInstructionsArgWrapper
        implements Cap2AssistRequestInstructionsArgWrapper {

    private transient Cap2IPSSPCapabilitiesWrapper cap2ipsspCapabilitiesWrapper = null;

    private IPSSPCapabilities txIpsspCapabilities;

    @Override
    public void setIPSSPCapabilitiesWrapper(final Cap2IPSSPCapabilitiesWrapper ipsspCapabilitiesWrapper) {
        if (ipsspCapabilitiesWrapper == null) {
            this.txIpsspCapabilities = null;
            this.cap2ipsspCapabilitiesWrapper = null;
        } else {
            final TxCap2IPSSPCapabilitiesWrapper txCap2IPSSPCapabilitiesWrapper = (TxCap2IPSSPCapabilitiesWrapper) ipsspCapabilitiesWrapper;
            this.txIpsspCapabilities = txCap2IPSSPCapabilitiesWrapper.getTxIpsspCapabilities();
            this.cap2ipsspCapabilitiesWrapper = txCap2IPSSPCapabilitiesWrapper;
        }
    }

    public Cap2IPSSPCapabilitiesWrapper getIPSSPCapabilitiesWrapper() {
        if(this.cap2ipsspCapabilitiesWrapper ==null&&this.txIpsspCapabilities !=null) {
            this.cap2ipsspCapabilitiesWrapper = new TxCap2IPSSPCapabilitiesWrapper(txIpsspCapabilities);
        }
        return this.cap2ipsspCapabilitiesWrapper;
    }

    public IPSSPCapabilities getTxIpsspCapabilities() {
        return txIpsspCapabilities;
    }

    public void setTxIpsspCapabilities(final IPSSPCapabilities txIpsspCapabilities) {
        this.txIpsspCapabilities = txIpsspCapabilities;
        this.cap2ipsspCapabilitiesWrapper = null;
    }

    @Override
    public String toString() {
        return "TxCap2AssistRequestInstructionsArgWrapper [txIpsspCapabilities=" + txIpsspCapabilities + "]";
    }

}
