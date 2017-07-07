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

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SmRpOaWrapper;

/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpOaWrapper implements SmRpOaWrapper {

    private transient ISDNAddressStringWrapper serviceCentreAddressOaWrapper = null;

    private ISDNAddressString serviceCentreAddressOa;

    public TxSmRpOaWrapper(){super();}

    @Override
    public ISDNAddressStringWrapper getServiceCentreAddressOA() {
        if (this.serviceCentreAddressOaWrapper == null && this.serviceCentreAddressOa != null) {
            this.serviceCentreAddressOaWrapper = new TxISDNAddressStringWrapperImpl(serviceCentreAddressOa);
        }
        return this.serviceCentreAddressOaWrapper;
    }

    public void setServiceCentreAddressOa(ISDNAddressStringWrapper serviceCentreAddressOa){
        if (serviceCentreAddressOa == null) {
            this.serviceCentreAddressOa = null;
            this.serviceCentreAddressOaWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl) serviceCentreAddressOa;
            this.serviceCentreAddressOa = txMsisdn.getTxAddress();
            this.serviceCentreAddressOaWrapper = txMsisdn;
        }
    }

    public ISDNAddressString getTxServiceCentreAddressOa() {
        return this.serviceCentreAddressOa;
    }

    public void setTxServiceCentreAddressOa(ISDNAddressString serviceCentreAddressOa) {
        this.serviceCentreAddressOa = serviceCentreAddressOa;
        this.serviceCentreAddressOaWrapper = null;

    }

    @Override
    public String toString() {
        return "TxSmRpOaWrapper [serviceCentreAddressOA=" + serviceCentreAddressOa + "]";
    }
}
