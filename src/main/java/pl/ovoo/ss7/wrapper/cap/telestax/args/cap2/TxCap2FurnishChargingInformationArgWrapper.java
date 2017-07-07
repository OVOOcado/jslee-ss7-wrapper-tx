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

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.FCIBCCCAMELsequence1;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2FCIBCCCAMELsequence1Wrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2FurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxFurnishChargingInformationArgWrapper;

/**
 * TxCap2FurnishChargingInformationArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2FurnishChargingInformationArgWrapper extends TxFurnishChargingInformationArgWrapper
        implements Cap2FurnishChargingInformationArgWrapper {

    private transient Cap2FCIBCCCAMELsequence1Wrapper fCIBCCCAMELsequence1 = null;

    private FCIBCCCAMELsequence1 txFCIBCCCAMELsequence1;

    @Override
    public Cap2FCIBCCCAMELsequence1Wrapper getFCIBCCCAMELsequence1() {
        if (this.fCIBCCCAMELsequence1 == null && txFCIBCCCAMELsequence1 != null) {
            this.fCIBCCCAMELsequence1 = new TxCap2FCIBCCCAMELsequence1Wrapper(txFCIBCCCAMELsequence1);
        }
        return this.fCIBCCCAMELsequence1;

    }

    @Override
    public void setFCIBCCCAMELsequence1(final Cap2FCIBCCCAMELsequence1Wrapper fcibcccameLsequence1) {
        if (fcibcccameLsequence1 == null) {
            this.txFCIBCCCAMELsequence1 = null;
            this.fCIBCCCAMELsequence1 = null;
        } else {
            final TxCap2FCIBCCCAMELsequence1Wrapper txCap2FCIBCCCAMELsequence1Wrapper = (TxCap2FCIBCCCAMELsequence1Wrapper) fcibcccameLsequence1;
            this.txFCIBCCCAMELsequence1 = txCap2FCIBCCCAMELsequence1Wrapper.getTxFCIBCCCAMELsequence1();
            this.fCIBCCCAMELsequence1 = txCap2FCIBCCCAMELsequence1Wrapper;
        }
    }

    public FCIBCCCAMELsequence1 getTxFCIBCCCAMELsequence1() {
        return txFCIBCCCAMELsequence1;
    }

    public void setTxFCIBCCCAMELsequence1(final FCIBCCCAMELsequence1 txFCIBCCCAMELsequence1) {
        this.txFCIBCCCAMELsequence1 = txFCIBCCCAMELsequence1;
        this.fCIBCCCAMELsequence1 = null;
    }

    @Override
    public String toString() {
        return "TxCap2FurnishChargingInformationArgWrapper [txFCIBCCCAMELsequence1=" + txFCIBCCCAMELsequence1 + "]";
    }

}
