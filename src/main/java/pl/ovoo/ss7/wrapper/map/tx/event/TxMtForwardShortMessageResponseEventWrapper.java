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

package pl.ovoo.ss7.wrapper.map.tx.event;

import org.mobicents.protocols.ss7.map.api.service.sms.MtForwardShortMessageResponse;
import pl.ovoo.ss7.wrapper.map.args.MtForwardSMResponseWrapper;
import pl.ovoo.ss7.wrapper.map.event.MtForwardSMResponseEventWrapper;
import pl.ovoo.ss7.wrapper.map.tx.args.TxMtForwardShortMessageResponseWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 09.06.17.
 */
public class TxMtForwardShortMessageResponseEventWrapper extends TxMapEventWrapper implements MtForwardSMResponseEventWrapper {

    private final MtForwardShortMessageResponse mtForwardShortMessageResponse;

    public TxMtForwardShortMessageResponseEventWrapper(final MtForwardShortMessageResponse mtForwardShortMessageResponse, final ActivityContextInterface aci) {
        super(aci);
        this.mtForwardShortMessageResponse = mtForwardShortMessageResponse;
    }

    @Override
    public MtForwardSMResponseWrapper getArgument() {
        TxMtForwardShortMessageResponseWrapper sri = new TxMtForwardShortMessageResponseWrapper();

        String text = new String(mtForwardShortMessageResponse.getSM_RP_UI().getData(),mtForwardShortMessageResponse.getSM_RP_UI().getGsm8Charset());
        sri.setText(text);
        return sri;
    }

    @Override
    public long getInvokeId() {
        return mtForwardShortMessageResponse.getInvokeId();
    }
}
