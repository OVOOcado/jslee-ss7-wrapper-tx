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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import pl.ovoo.ss7.wrapper.cap.args.InformationToSendWrapper;
import pl.ovoo.ss7.wrapper.cap.args.PlayAnnouncementArgWrapper;

/**
 * TxPlayAnnouncementArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxPlayAnnouncementArgWrapper implements PlayAnnouncementArgWrapper {

    private transient InformationToSendWrapper informationToSend = null;

    private Boolean txRequestAnnouncementComplete;
    private InformationToSend txInformationToSend;

    @Override
    public void setRequestAnnouncementComplete(final Boolean value) {
        txRequestAnnouncementComplete = value;
    }

    @Override
    public void setInformationToSend(final InformationToSendWrapper informationToSend) {
        if (informationToSend == null) {
            this.txInformationToSend = null;
            this.informationToSend = null;
        } else {
            final TxInformationToSendWrapper txInformationToSendWrapper = (TxInformationToSendWrapper) informationToSend;
            this.txInformationToSend = txInformationToSendWrapper.getTxInformationToSend();
            this.informationToSend = txInformationToSendWrapper;
        }
    }

    public InformationToSendWrapper getInformationToSendWrapper() {
        if (this.informationToSend == null && this.txInformationToSend != null) {
            this.informationToSend = new TxInformationToSendWrapper(txInformationToSend);
        }
        return this.informationToSend;
    }

    public InformationToSend getTxInformationToSend() {
        return txInformationToSend;
    }

    public void setTxInformationToSend(final InformationToSend txInformationToSend) {
        this.txInformationToSend = txInformationToSend;
        this.informationToSend = null;
    }

    public Boolean getTxRequestAnnouncementComplete() {
        return txRequestAnnouncementComplete;
    }

    public void setTxRequestAnnouncementComplete(final Boolean txRequestAnnouncementComplete) {
        this.txRequestAnnouncementComplete = txRequestAnnouncementComplete;
        
    }

    @Override
    public String toString() {
        return "TxPlayAnnouncementArgWrapper [informationToSendWrapper=" + informationToSend
                + ", txRequestAnnouncementComplete=" + txRequestAnnouncementComplete + ", txInformationToSend="
                + txInformationToSend + "]";
    }

}
