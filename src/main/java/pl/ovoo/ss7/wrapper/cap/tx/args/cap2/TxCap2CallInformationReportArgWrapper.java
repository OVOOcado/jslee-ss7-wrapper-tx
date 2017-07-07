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

import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import pl.ovoo.ss7.wrapper.cap.args.ReceivingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxCallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.tx.args.TxReceivingSideIDWrapper;

/**
 * TxCap2CallInformationReportArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2CallInformationReportArgWrapper extends TxCallInformationReportArgWrapper
        implements Cap2CallInformationReportArgWrapper {

    private transient ReceivingSideIDWrapper legID = null;

    private ReceivingSideID txLegID;

    @Override
    public void setLegID(final ReceivingSideIDWrapper legID) {
        if (legID == null) {
            this.txLegID = null;
            this.legID = null;
        } else {
            final TxReceivingSideIDWrapper txReceivingSideIDWrapper = (TxReceivingSideIDWrapper) legID;
            this.txLegID = txReceivingSideIDWrapper.getTxReceivingSideID();
            this.legID = txReceivingSideIDWrapper;
        }
    }

    public ReceivingSideIDWrapper getLegID() {
        if (this.legID == null && this.txLegID != null) {
            this.legID = new TxReceivingSideIDWrapper(txLegID);
        }
        return this.legID;
    }

    public ReceivingSideID getTxLegID() {
        return txLegID;
    }

    public void setTxLegID(final ReceivingSideID txLegID) {
        this.txLegID = txLegID;
        this.legID = null;
    }

    @Override
    public String toString() {
        return "TxCap2CallInformationReportArgWrapper [txLegID=" + txLegID + "]";
    }

}
