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

package pl.ovoo.jslee.ss7.wrapper.map.tx.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.map.api.service.sms.MtForwardShortMessageRequest;
import org.mobicents.protocols.ss7.map.primitives.ISDNAddressStringImpl;

import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpDaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.MtForwardShortMessageRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMtForwardShortMessageRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpOaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpUiWrapper;


/**
 * Created by karolsimka on 08.06.17.
 */
public class TxMtForwardShortMessageRequestEventWrapper extends TxMapEventWrapper implements MtForwardShortMessageRequestEventWrapper {

    /** The mt forward short message request. */
    private final MtForwardShortMessageRequest mtForwardShortMessageRequest;

    /**
     * Instantiates a new tx mt forward short message request event wrapper.
     *
     * @param mtForwardShortMessageRequest the mt forward short message request
     * @param aci the aci
     */
    public TxMtForwardShortMessageRequestEventWrapper(final MtForwardShortMessageRequest mtForwardShortMessageRequest, final ActivityContextInterface aci) {
        super(aci);
        this.mtForwardShortMessageRequest = mtForwardShortMessageRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MtForwardShortMessageRequestEventWrapper#getArgument()
     */
    @Override
    public MtForwardShortMessageRequestWrapper getArgument() {
        TxMtForwardShortMessageRequestArgWrapper txMtForwardShortMessageRequestArgWrapper = new TxMtForwardShortMessageRequestArgWrapper();

        TxSmRpDaWrapper sm_rp_da = new TxSmRpDaWrapper();
        sm_rp_da.setIMSI(new TxIMSIAddressWrapper(mtForwardShortMessageRequest.getSM_RP_DA().getIMSI()));
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Da(sm_rp_da);

        TxSmRpOaWrapper sm_rp_oa = new TxSmRpOaWrapper();
        sm_rp_oa.setTxServiceCentreAddressOa(new ISDNAddressStringImpl(mtForwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA().getAddressNature(),mtForwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA().getNumberingPlan(),mtForwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA().getAddress()));
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Oa(sm_rp_oa);

        TxSmRpUiWrapper sm_rp_ui = new TxSmRpUiWrapper();
        sm_rp_ui.setData(mtForwardShortMessageRequest.getSM_RP_UI().getData());
        sm_rp_ui.setCharset(DataCodingWrapper.lookup(mtForwardShortMessageRequest.getSM_RP_UI().getGsm8Charset().name()));
        
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Ui(sm_rp_ui);

        return txMtForwardShortMessageRequestArgWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId() {
        return mtForwardShortMessageRequest.getInvokeId();
    }
}
