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

import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import pl.ovoo.jslee.ss7.wrapper.cap.args.SendingSideIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2CallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxSendingSideIDWrapper;

/**
 * TxCap2CallInformationRequestArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2CallInformationRequestArgWrapper extends TxCallInformationRequestArgWrapper
        implements Cap2CallInformationRequestArgWrapper {

    private transient SendingSideIDWrapper legID = null;

    private SendingSideID txLegID;

    @Override
    public void setLegID(final SendingSideIDWrapper sendingSideID) {
        if (sendingSideID == null) {
            this.txLegID = null;
            this.legID = null;
        } else {
            final TxSendingSideIDWrapper txSendingSideIDWrapper = (TxSendingSideIDWrapper) sendingSideID;
            this.txLegID = txSendingSideIDWrapper.getTxSendingSideID();
            this.legID = txSendingSideIDWrapper;
        }

    }

    @Override
    public SendingSideIDWrapper getLegID() {
        if (this.legID == null && txLegID != null) {
            this.legID = new TxSendingSideIDWrapper(txLegID);
        }
        return this.legID;
    }

    public SendingSideID getTxLegID() {
        return txLegID;
    }

    public void setTxLegID(final SendingSideID txLegID) {
        this.txLegID = txLegID;
        this.legID = null;
    }

    @Override
    public String toString() {
        return "TxCap2CallInformationRequestArgWrapper [txLegID=" + txLegID + "]";
    }

}
