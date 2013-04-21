/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space.apps.challenge;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import space.apps.challenge.entities.Agile;
import space.apps.challenge.util.Assets;

public class AgileArrayAdapter extends ArrayAdapter<Agile> {

    private final List<Agile> list;
    private final Activity context;

    public AgileArrayAdapter(Activity context, List<Agile> list) {
        super(context, R.layout.agile_list_layout, list);
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {

        protected TextView satellite, organization, type, launched, height;
        protected ImageView image;
    }
    String plaintext = "";
    String imageURL = "";
    ViewHolder holder = null;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.agile_list_layout, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.satellite = (TextView) view.findViewById(R.id.satellite);
            viewHolder.satellite.setTextColor(Color.BLACK);
            viewHolder.organization = (TextView) view.findViewById(R.id.organization);
            viewHolder.organization.setTextColor(Color.GRAY);
            viewHolder.type = (TextView) view.findViewById(R.id.type);
            viewHolder.type.setTextColor(Color.GRAY);
            viewHolder.launched = (TextView) view.findViewById(R.id.launched);
            viewHolder.launched.setTextColor(Color.GRAY);
            viewHolder.height = (TextView) view.findViewById(R.id.height);
            viewHolder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(viewHolder);
        } else {
            view = convertView;
//            ((ViewHolder) view.getTag()).time.setTag(list.get(position));
        }
        holder = (ViewHolder) view.getTag();
//        holder.text.setText("text");
//        holder.text.setText("Text");
//        WASubpod[] sub = list.get(position).getSubpods();
//
//        for (WASubpod subpod : sub) {
//            for (Object element : subpod.getContents()) {
//                if (element instanceof WAPlainText) {
//                    plaintext = ((WAPlainText) element).getText();
//                }
//                if (element instanceof WAImage) {
//                    imageURL = ((WAImage) element).getURL();
//                }
//            }
//        }

//        SimpleDateFormat sdf = new SimpleDateFormat();        
//        holder.time.setText(sdf.format(list.get(position).getTime()));
//        if (!imageURL.equals("")) {
////            Assets.imageDownloader.download(imageURL, holder.time);
//            Assets.drawableManager.fetchDrawableOnThread(imageURL, holder.time);
//        } else {
//            holder.narrative.setText(plaintext);
//        }
        
        holder.satellite.setText("Satellite");
        holder.image.setImageBitmap(null);
        holder.organization.setText("Organization");
        holder.type.setText("Type");
        holder.launched.setText("Launched");
        holder.height.setText("Height");
        return view;
    }
}