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
import pl.ovoo.ss7.wrapper.common.args.SmDeliveryOutcome;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SmsDeliverTpduWrapper;

/**
 * Created by karolsimka on 12.06.17.
 */
public class TxSmsDeliverTpduWrapper implements SmsDeliverTpduWrapper {

    private ISDNAddressString msisdn;

    private org.mobicents.protocols.ss7.map.api.service.sms.SMDeliveryOutcome smDeliveryOutcome;

    public TxSmsDeliverTpduWrapper() {super();}

    @Override
    public ISDNAddressStringWrapper getMsisdn(){
        return new TxISDNAddressStringWrapperImpl(msisdn);
    }

    public void setMsisdn(ISDNAddressStringWrapper msisdn){
        TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl)msisdn;
        this.msisdn = txMsisdn.getTxAddress();
    }

    @Override
    public SmDeliveryOutcome getOutcome() {
        return SmDeliveryOutcome.valueOf(this.smDeliveryOutcome.getCode());
    }

    public void setSmDeliveryOutcome(pl.ovoo.ss7.wrapper.common.args.SmDeliveryOutcome smDeliveryOutcome){
        this.smDeliveryOutcome = org.mobicents.protocols.ss7.map.api.service.sms.SMDeliveryOutcome.getInstance(smDeliveryOutcome.getValue());
    }
}
