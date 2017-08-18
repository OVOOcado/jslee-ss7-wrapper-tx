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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SmRpDaWrapper;


/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpDaWrapper implements SmRpDaWrapper {

    /** The imsi address wrapper. */
    private transient IMSIAddressWrapper imsiAddressWrapper = null;

    /** The imsi. */
    private IMSI imsi;

    /**
     * Instantiates a new tx sm rp da wrapper.
     */
    public TxSmRpDaWrapper() {super();}

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SmRpDaWrapper#getIMSI()
     */
    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    /**
     * Sets the imsi.
     *
     * @param imsi the new imsi
     */
    public void setIMSI(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddressWrapper = null;
        } else {
            TxIMSIAddressWrapper txImsi = (TxIMSIAddressWrapper) imsi;
            this.imsi = txImsi.getTxImsi();
            this.imsiAddressWrapper = txImsi;
        }
    }

    /**
     * Gets the tx imsi.
     *
     * @return the tx imsi
     */
    public IMSI getTxImsi() {
        return this.imsi;
    }

    /**
     * Sets the tx imsi.
     *
     * @param imsi the new tx imsi
     */
    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxSmRpDaWrapper [IMSI=" + imsi + "]";
    }
}
