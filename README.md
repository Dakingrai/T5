# Install requirements
```pip install torch==1.12.1+cu116 torchvision==0.13.1+cu116 torchaudio==0.12.1 --extra-index-url https://download.pytorch.org/whl/cu116
pip install -r requirements.txt
```

# Start the training
```
deepspeed --master_port 2428 main.py configs/train_deepspeed.json # Run with deepspeed
```
```
python main.py configs/train.json # Run without deepspeed
```

